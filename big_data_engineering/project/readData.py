from pyspark.context import SparkContext
from pyspark.sql import SQLContext
import re

# get spark sql context
sc = SparkContext.getOrCreate()
sqlc = sqlc = SQLContext(sc)

# read data from S3 bucket
cars = sqlc.read.csv("s3a://mys3projectbucket/Data/used_cars_data.csv", header=True) # data is in location specified
# check first two rows
cars.show(n=2)

