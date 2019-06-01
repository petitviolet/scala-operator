compile:
	sbt -mem 2048 compile

compile/operator:
	sbt -mem 2048 'project operator' compile

release:
	sbt clean compile test 'project operator' '+publishSigned'  sonatypeReleaseAll

