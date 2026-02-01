@echo off
chcp 65001 > nul

echo {} | java -XX:AOTCache=..\FFProbeChapters2Cue.aot -XX:+UseCompactObjectHeaders -jar ..\build\libs\FFProbeChapters2Cue.jar

if %ERRORLEVEL% NEQ 0 (
  echo ERRORLEVEL: %ERRORLEVEL%
)

pause
