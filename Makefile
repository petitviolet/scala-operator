compile:
	sbt -mem 2048 compile

release: compile
	sbt 'project operator' publishSigned && sbt 'project operator' sonatypeRelease

