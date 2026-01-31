@echo off
chcp 65001 > nul

java -XX:AOTCache=..\FFProbeChapters2Cue.aot -XX:+UseCompactObjectHeaders -jar ..\build\libs\FFProbeChapters2Cue.jar -h

pause
