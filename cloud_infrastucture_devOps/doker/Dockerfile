# Dockerfile
FROM ghcr.io/ustseis615/ubuntu:xenial
LABEL maintainer="Carolin Poschen <posc2628@stthomas.edu>"
EXPOSE 8080
RUN apt-get update -y
RUN apt-get install python-pip -y
RUN apt-get install python-dev -y
COPY /app/site.py /app/site.py
COPY /app/requirements.txt /app/requirements.txt
WORKDIR /app
RUN pip install -r requirements.txt
CMD python site.py
