#!/bin/bash

javac -sourcepath code -d bin $1 && java -cp bin $2