#include <stdio.h>
#include <math.h>

// C++ code for task 2, assuming all necessary includes have been done
int main() {
	double pi = 2 * acos(0.0); // this is a more accurate way to compute pi
	int n;
	scanf("%d", &n);
	printf("%.*lf\n", n, pi); // this is the way to manipulate field width
}