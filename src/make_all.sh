#!/bin/bash

cd `dirname $0`

export CLASSPATH=.:`hadoop classpath`
javac ./*/*/*/*/*.java

