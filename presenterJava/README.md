# presenter picker in Java
Give a set of presenters pick one randomly, excluding missing ones passed as arguments.

Usage:

mvn assembly:single

Copy the produced jar and add on the same path a presenters.txt containing the candidate presenters separated by a new line.


e.g. printf "gianni\nenri\nmario" > presenters.txt ;  java -jar presenterJava-1.0-jar-with-dependencies.jar [enri]
