#!/usr/bin/env bash

if [[ -z $1 ]]; then
    echo "Please type a valid action: build, run";
elif [[ $1 == "build" ]]; then
    cd compiler
    mvn clean package assembly:single
elif [[ $1 == "run" ]]; then
    first=false
    params=""

    for arg in $@; do
        if [[ $first == false ]]; then
            first=true
        else
            params=$params$arg
        fi
    done

    java -cp compiler/target/compiler-1.0-jar-with-dependencies.jar compiler.App $params
else
    echo "Please type a valid action: build, run";
fi


   
