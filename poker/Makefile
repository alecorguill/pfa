TST=model.TestCard\
model.TestDeck\
model.TestHand\
model.TestValue\
model.TestPlayer\
model.TestPot


all: clean
	javac -d build -cp build src/* test/*
	java -ea -cp build model.TestLauncher $(TST)
	java -cp build model.Launch

warning : clean
	javac -Xlint:unchecked -d build -cp build src/* test/*
	java -ea -cp build model.TestLauncher $(TST)

TestCard: clean
	javac -d build -cp build test/*
	java -ea -cp build model.TestLauncher model.TestCard

TestDeck: clean
	javac -d build -cp build test/*
	java -ea -cp build model.TestLauncher model.TestDeck

TestHand: clean
	javac -d build -cp build test/*
	java -ea -cp build model.TestLauncher model.TestHand

TestValue: clean
	javac -d build -cp build test/*
	java -ea -cp build model.TestLauncher model.TestValue

TestPlayer: clean
	javac -d build -cp build test/*
	java -ea -cp build model.TestLauncher model.TestPlayer

TestPot: clean
	javac -d build -cp build test/*
	java -ea -cp build model.TestLauncher model.TestPot

clean:
	rm -rf build/* src/*~ src/#* test/*~ test/#*
