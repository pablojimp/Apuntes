#!/bin/bash
suma_hasta_n() {
    local n=$1
    echo $(( n * (n + 1) / 2 ))
}

suma_hasta_n 5



