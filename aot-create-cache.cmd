@echo off
chcp 65001 > nul

echo Building new AOT cache ...
java -XX:AOTCacheOutput=FFProbeChapters2Cue.aot -XX:+UseCompactObjectHeaders -jar .\build\libs\FFProbeChapters2Cue.jar -h

echo ERRORLEVEL:%ERRORLEVEL%

pause
