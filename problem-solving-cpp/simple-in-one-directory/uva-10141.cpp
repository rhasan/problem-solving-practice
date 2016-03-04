#include <stdio.h>
#include <string>
#include <vector>       // std::vector
#include <algorithm>    // std::sort
#include <map>
#include <limits>
#include <string.h>

using namespace std;

#define ALL(x) x.begin(), x.end()


int main() {
	int n, p, tc, r;
	char str[82];
	double cost;

	tc = 1;
	while(scanf("%d %d\n",&n,&p) != EOF) {
		if(n==0 && p==0) break;
		if(tc > 1)
			printf("\n");

		printf("RFP #%d\n", tc++);

		for (int i = 0; i < n; i++) {
			//scanf("%s", str);
			gets(str);
		}
		int max_req_met = -1;
		double min_cost =  numeric_limits<double>::max();
		char res_name[82] = "";

		
		for (int i = 0; i < p; i++) {
			gets(str);
			//scanf("%s", str);
			//printf("%s\n", str);
			scanf("%lf %d\n",&cost,&r);

			if (max_req_met < r) {
				max_req_met = r;
				min_cost = cost;
				strcpy(res_name, str);
			} else if (max_req_met == r && min_cost > cost) {
				max_req_met = r;
				min_cost = cost;
				strcpy(res_name, str);
			} 

			for (int j = 0; j < r; j++) {
				gets(str);
			}
		}

		printf("%s\n", res_name);
	}
	return 0;
}

