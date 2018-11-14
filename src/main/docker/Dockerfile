FROM openjdk:11-jdk

COPY maven/target/dependency /app/modules
COPY maven/target/*.jar /app/modules

# TODO: PB: COPY settings file for FlightRecorder
# https://docs.oracle.com/javacomponents/jmc-5-5/jfr-command-reference/diagnostic-command-reference.htm#resourceid-15322-48C8362A

CMD java \
#         -XX:+FlightRecorder \
#         -XX:StartFlightRecording=disk=true,filename=/tmp/jfr/recording.jfr,maxage=24h,dumponexit=true,path-to-gc-roots=true \
         --module-path app/modules \
         --module pbouda.docker.jfr/pbouda.docker.jfr.Application