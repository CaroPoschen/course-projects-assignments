# Dockerfile
FROM ghcr.io/ustseis615/python:3.8-slim-buster
LABEL maintainer="Carolin Poschen <posc2628@stthomas.edu>"
EXPOSE 8090
RUN apt-get update -y
RUN apt-get install python-pip -y
RUN apt-get install python-dev -y
COPY /app/scr/main.py /app/scr/main.py
COPY /app/scr/requirements.txt /app/scr/requirements.txt
WORKDIR /app/scr
RUN pip install -r requirements.txt
ENTRYPOINT python
CMD main.py