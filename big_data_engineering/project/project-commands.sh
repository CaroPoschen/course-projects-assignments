# based on lab-commands.sh of SEIS736-02 lab 7

############################################
# INITIALIZE PARAMETERS AND VARIABLES  #
############################################
CLIENT_IP="" # Change this line
ENV_NAME="emr-cluster"
STACK_NAME="${ENV_NAME}-stack"
KEY_NAME="${ENV_NAME}-keypair"
KEY_FILE="${KEY_NAME}.pem"
CLOUD9_PRIVATE_IP=`hostname -i`

############################################
# CREATE INFRASTRUCTURE USING AWS CLI  #
############################################
aws configure set region us-east-1
export AWS_SHARED_CREDENTIALS_FILE=/home/ec2-user/.aws/credentials

CIDR_SUFFIX=
if [ "${CLIENT_IP}" = "0.0.0.0" ]; then
    CIDR_SUFFIX="/0"
else
    CIDR_SUFFIX="/32"
fi

aws ec2 create-key-pair \
    --key-name "${KEY_NAME}" \
    --query 'KeyMaterial' \
    --output text > "${KEY_FILE}"

chmod 400 "${KEY_FILE}" #change permissions

aws cloudformation deploy \
  --template-file ./template.json \
  --stack-name "project-emr-cluster-stack" \
  --capabilities CAPABILITY_NAMED_IAM \
  --parameter-overrides \
    Name="${ENV_NAME}" \
    InstanceType=m4.large \
    ClientIP="${CLIENT_IP}${CIDR_SUFFIX}" \
    Cloud9IP="${CLOUD9_PRIVATE_IP}/32" \
    InstanceCount=2 \
    KeyPairName="${KEY_NAME}" \
    ReleaseLabel="emr-5.32.0" \
    EbsRootVolumeSize=32

############################################
# CONNECT TO EMR MASTER NODE   #
############################################
CLUSTER_ID=`aws emr list-clusters --query "Clusters[?Name=='${ENV_NAME}'].Id | [0]" --output text`
aws emr wait cluster-running --cluster-id ${CLUSTER_ID}
EMR_MASTER_PUBLIC_HOST=`aws emr describe-cluster --cluster-id ${CLUSTER_ID} --query Cluster.MasterPublicDnsName --output text`

# shell into EMR
ssh -i "${KEY_FILE}" "hadoop@${EMR_MASTER_PUBLIC_HOST}"

pyspark
# run python program

############################################
# DELETE RESOURCES                     
############################################

aws cloudformation delete-stack --stack-name "project-emr-cluster-stack"
aws cloudformation wait stack-delete-complete --stack-name "project-emr-cluster-stack"
