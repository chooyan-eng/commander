# Overview

"commander" is a tool to analyze your CLI (such as Linux/Unix or Windows Command Prompt) history.

# How to use

## 1. Clone the repository

```
$ git clone https://github.com/chooyan-eng/commander.git 
```

## 2. build

```
$ ./gradlew build
```

## 3. place your command history file, named "command.txt"

```
$ history > ./command.txt
```

## 4. place config file, named "config.yml"

```
$ echo "inputFile: command.txt" > config.yml
$ echo "parser: jp.co.chooyan.commander.plugin.parse.SimpleCommandParser" >> config.yml
$ echo "analyzer: jp.co.chooyan.commander.plugin.analyze.HistoryCountAnalyzer" >> config.yml
$ echo "outputter: jp.co.chooyan.commander.plugin.output.JsonOutputter" >> config.yml
```

## 5. Run JAR file with full path to current directory as an argument

```
$ java -jar build/libs/commander.jar ${PWD}
```

_Note that java8 is installed to your machine._

## 6. Result will be output as standard output

```
{"ll":118,"javac":21,"ln":2,"ps":2,"ls":34,"file":1,"git":115,"java":16,"od":4,"cat":4,"vagrant":11,"mysql":1,"man":7,"999999999":1,"mkdir":8,"gibo":5,"which":1,"cd":54,"grep":3,"clear":1,"tree":3,"touch":1,"history":4,"l":2,"cp":3,"lll":3,"script":2,"gradle":9,"llll":1,"vi":42,"/usr/libexec/java":1,"service":1,"rm":6,"./gradlew":6,"pwd":5,"open":2}
```