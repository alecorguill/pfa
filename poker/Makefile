TST=poker.TestCard\
poker.TestDeck\
poker.TestHand\
poker.TestValue\
poker.TestPlayer\
poker.TestPot


all: clean
	javac -d build -cp build src/* test/*
	java -ea -cp build poker.TestLauncher $(TST)
	java -cp build poker.Launch

warning : clean
	javac -Xlint:unchecked -d build -cp build src/* test/*
	java -ea -cp build poker.TestLauncher $(TST)

TestCard: clean
	javac -d build -cp build test/*
	java -ea -cp build poker.TestLauncher poker.TestCard

TestDeck: clean
	javac -d build -cp build test/*
	java -ea -cp build poker.TestLauncher poker.TestDeck

TestHand: clean
	javac -d build -cp build test/*
	java -ea -cp build poker.TestLauncher poker.TestHand

TestValue: clean
	javac -d build -cp build test/*
	java -ea -cp build poker.TestLauncher poker.TestValue

TestPlayer: clean
	javac -d build -cp build test/*
	java -ea -cp build poker.TestLauncher poker.TestPlayer

TestPot: clean
	javac -d build -cp build test/*
	java -ea -cp build poker.TestLauncher poker.TestPot

clean:
	rm -rf build/* src/*~ src/#* test/*~ test/#*
