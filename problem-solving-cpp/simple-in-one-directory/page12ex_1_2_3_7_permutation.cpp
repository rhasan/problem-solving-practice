#include <stdio.h>
#include <algorithm>	//std::next_permutation, std::sort
using namespace std;

#define N 3

int main() {
	char p[N];

	for(int i = 0; i < N; i++) {
		p[i] = i + 'A';
	}

	do {
		for(int i = 0; i < N; i++) {
			printf("%c",p[i]);
		}
		printf("\n");		
	} while(next_permutation(p,p+N));
}
