#!/bin/bash
isExistApp=`pgrep -f app.py`
if [[ -n  $isExistApp ]]; then
    kill $isExistApp       
fi