PROB=$1
echo "Judging UVA problem: "$PROB
g++ uva-$PROB.cpp
./a.out < input/$PROB.in > output/my$PROB.out

DIFF=$(diff output/my$PROB.out output/$PROB.out)

if [ "$DIFF" != "" ] 
then
    echo "Incorrect output :("
    echo $DIFF
else
	echo "Correct output!"
fi
