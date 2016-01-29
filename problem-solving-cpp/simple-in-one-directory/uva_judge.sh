PROB=$1
echo "Judging UVA problem: "$PROB
rm -f a.out
COMPLIE=$(g++ uva-$PROB.cpp)
if [ "$?" != "0" ]
then
	echo $COMPLIE
	exit 1
fi
./a.out < input/$PROB.in > out/my$PROB.out

DIFF=$(diff output/my$PROB.out out/$PROB.out)

if [ "$DIFF" != "" ] 
then
    echo "Incorrect output :("
    echo $DIFF
else
	echo "Correct output!"
fi
