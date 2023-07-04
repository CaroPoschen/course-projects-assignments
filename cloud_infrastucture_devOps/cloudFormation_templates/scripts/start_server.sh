#!/bin/bash
isExistApp=`pgrep -f app.py`
if [[ -z  $isExistApp ]]; then
    python3 /opt/python-app/app.py > /dev/null 2> /dev/null < /dev/null &       
fi