@echo off
chcp 65001 > nul

java -XX:AOTCache=..\FFProbeChapters2Cue.aot -XX:+UseCompactObjectHeaders -jar ..\build\libs\FFProbeChapters2Cue.jar -i ..\src\test\resources\FFProbeChapters_1.json --out-file .\FFProbeChapters_1.cue

pause
