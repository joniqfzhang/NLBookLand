# NLBookLand - the steps to clone local copy

Method 1: download the project and run 

1.Go to https://github.com/joniqfzhang/NLBookLand;
2.Click button of  "Clone or download", select "Download ZIP", and download the zip file NLBookLand-master.zip;
3.Unzip NLBookLand-master.zip to a folder {path};
4.Open command prompt and change directory to: {path}\NLBookLand-master\NLBookLand;
5.Run command: mvn jetty:run;
6.Wait until jetty server start up with console info like:
	[INFO] Started Jetty Server
	[INFO] Start Jetty Server
7.Type in a browser URL: http://localhost:8080/, and NLBookLand home page will display.

Method 2: clone with git command-line
1. Open git command-line, and change to a directory to the location you want the cloned directory({path}) to be made;
2. Type 
	git clone https://github.com/joniqfzhang/NLBookLand; 
3. Change command-line directory to 
	{path}/NLBookLand/NLBookLand
4. Type
	mvn jetty:run
5. Wait until jetty server start up with console info like:
	[INFO] Started Jetty Server
	[INFO] Start Jetty Server
6. Type in a browser URL: http://localhost:8080/, and NLBookLand home page will display.