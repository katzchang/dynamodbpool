
all: sample

sample:
	./sbt sample

sample-continuous:
	./sbt ~sample

jetty-run:
	@echo to sample: curl '"http://localhost:8080/hello?hoge=fuga&hoge=piyo&foo=bar"'
	mvn jetty:run

package:
	mvn package

idea:
	./sbt gen-idea

eclipse:
	./sbt eclipse
