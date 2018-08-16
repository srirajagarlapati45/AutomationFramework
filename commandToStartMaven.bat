@echo off
title Automation Execution
echo Automation Scripts Execution.
pause
SET DEVELOPMENT_HOME=D:\sree\
cd %DEVELOPMENT_HOME%\wings\
call mvn clean install
echo Execution is Compilited.
pause