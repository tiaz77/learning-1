#!/bin/bash

if [ "$#" -lt 1 ]
then
	echo "usage:   $(basename $0) seed"
	echo "example: $(basename $0) 5 'to get a random number in [1,5]'"
	exit 0
fi

echo $RANDOM % $1 + 1 | bc
