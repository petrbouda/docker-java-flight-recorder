# How to run Java Flight Recorder inside Docker

```bash
docker run -it -p 8080:8080 docker-jfr
```

#### Links

> https://medium.com/@chrishantha/using-java-flight-recorder-2367c01deacf
- https://docs.oracle.com/javacomponents/jmc-5-4/jfr-runtime-guide/run.htm#JFRUH164
- https://docs.oracle.com/javase/10/troubleshoot/troubleshoot-performance-issues-using-jfr.htm#JSTGD299
- https://www.oracle.com/technetwork/java/javase/jmc6-release-notes-3689600.html

#### Warnings

- Beware some Docker versions of OpneJDK does not contains JFR profiles, you will end up with this:

```
root@b03df92bfa39:/docker-java-home/lib# jcmd 8 JFR.start delay=20s duration=60s name=Test filename=recording.jfr
8:
Could not parse setting default
```

#### Enable JFR using JCMD

... 