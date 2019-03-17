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
```

- Profiles:

```
bash-4.2# ls /docker-java-home/lib/jfr/
default.jfc  profile.jfc
```

#### Enable JFR using JCMD

```
JFR.check
JFR.configure
JFR.dump
JFR.start
JFR.stop
```

```
bash-4.2# jcmd 1 help JFR.configure
1:
JFR.configure
Configure JFR

Impact: Low

Permission: java.lang.management.ManagementPermission(monitor)

Syntax : JFR.configure [options]

Options: (options must be specified using the <key> or <key>=<value> syntax)
	repositorypath : [optional] Path to repository,.e.g \"My Repository\" (STRING, no default value)
	dumppath : [optional] Path to dump,.e.g \"My Dump path\" (STRING, no default value)
	stackdepth : [optional] Stack Depth (JLONG, 64)
	globalbuffercount : [optional] Number of global buffers, (JLONG, 32)
	globalbuffersize : [optional] Size of a global buffers, (JLONG, 524288)
	thread_buffer_size : [optional] Size of a thread buffer (JLONG, 8192)
	memorysize : [optional] Overall memory size,  (JLONG, 16777216)
	maxchunksize : [optional] Size of an individual disk chunk (JLONG, 12582912)
	samplethreads : [optional] Activate Thread sampling (BOOLEAN, true)
	
####################################

bash-4.2# jcmd 1 JFR.configure
1:
Current configuration:

Repository path: N/A
Stack depth: 64
Global buffer count: 20
Global buffer size: 512.0 kB
Thread buffer size: 8.0 kB
Memory size: 10.0 MB
Max chunk size: 12.0 MB
Sample threads: true
```

- https://docs.oracle.com/javacomponents/jmc-5-5/jfr-command-reference/diagnostic-command-reference.htm#resourceid-15322-48C8362A

```
bash-4.2# jcmd 1 help JFR.start
1:
JFR.start
Starts a new JFR recording

Impact: Medium: Depending on the settings for a recording, the impact can range from low to high.

Permission: java.lang.management.ManagementPermission(monitor)

Syntax : JFR.start [options]

Options: (options must be specified using the <key> or <key>=<value> syntax)
	name : [optional] Name that can be used to identify recording, e.g. \"My Recording\" (STRING, no default value)
	settings : [optional] Settings file(s), e.g. profile or default. See JRE_HOME/lib/jfr (STRING SET, no default value)
	delay : [optional] Delay recording start with (s)econds, (m)inutes), (h)ours), or (d)ays, e.g. 5h. (NANOTIME, 0)
	duration : [optional] Duration of recording in (s)econds, (m)inutes, (h)ours, or (d)ays, e.g. 300s. (NANOTIME, 0)
	disk : [optional] Recording should be persisted to disk (BOOLEAN, no default value)
	filename : [optional] Resulting recording filename, e.g. \"/home/user/My Recording.jfr\" (STRING, no default value)
	maxage : [optional] Maximum time to keep recorded data (on disk) in (s)econds, (m)inutes, (h)ours, or (d)ays, e.g. 60m, or 0 for no limit (NANOTIME, 0)
	maxsize : [optional] Maximum amount of bytes to keep (on disk) in (k)B, (M)B or (G)B, e.g. 500M, or 0 for no limit (MEMORY SIZE, 0)
	dumponexit : [optional] Dump running recording when JVM shuts down (BOOLEAN, no default value)
	path-to-gc-roots : [optional] Collect path to GC roots (BOOLEAN, false)
```