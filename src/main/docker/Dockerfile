FROM openjdk:11

COPY./target/dependency /app/modules
COPY ./target/*.jar /app/modules


CMD java \
#         -XX:+FlightRecorder \
#         -XX:StartFlightRecording=disk=true,filename=/tmp/jfr/recording.jfr,maxage=24h,dumponexit=true,path-to-gc-roots=true \
         --module-path app/modules \
         --module pbouda.docker.jfr/pbouda.docker.jfr.Application