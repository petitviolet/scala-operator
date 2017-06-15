compile:
	sbt -mem 2048 compile

compile/operator:
	sbt -mem 2048 'project operator' compile

release: compile/operator
	sbt 'project operator' publishSigned && sbt 'project operator' sonatypeRelease

