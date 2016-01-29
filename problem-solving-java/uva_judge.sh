PROB=$1
echo "Judging UVA problem: "$PROB
java -classpath ./bin Main < input/$PROB.in > output/my$PROB.out

DIFF=$(diff output/my$PROB.out output/$PROB.out)

if [ "$DIFF" != "" ] 
then
    echo "Incorrect output :("
    echo $DIFF
else
	echo "Correct output!"
fi
