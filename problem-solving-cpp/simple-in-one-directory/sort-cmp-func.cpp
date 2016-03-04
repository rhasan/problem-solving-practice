#include <stdio.h>
#include <string>
#include <vector>       // std::vector
#include <algorithm>    // std::sort
#include <map>

using namespace std;

#define ALL(x) x.begin(), x.end()

struct desc {
	//vector<string> requirements;
	int total_requirements;
};

struct rfp {
	string name;
	//vector<string> requirements;
	int total_met;
	//map<string,bool> is_compliant;
	double price;
	int seq_no;
	double compliance;
};

bool cmp_func (rfp i, rfp j) {
 	if (i.total_met > j.total_met) return true;
 	if (i.total_met < j.total_met) return false;
 	if (i.price < j.price) return true;
 	if (i.price > j.price) return false;
 	return (i.seq_no < j.seq_no);

}

void print_debug(vector<rfp> &proposals, int p) {
	for (int i = 0; i < p; i++) {
		rfp prp = proposals[i];
		printf("Name: %s\n", prp.name.c_str());
		printf("Compliance: %lf\n", prp.compliance);
		printf("Price: %lf\n", prp.price);
		printf("Sequence: %d\n", prp.seq_no);

	}	
}

struct Xgreater
{
    bool operator()( const rfp &i, const rfp &j ) const {
	 	if (i.total_met > j.total_met) return true;
	 	else if (i.total_met == j.total_met) {
//	 		if (i.total_met < j.total_met) return false;
	 		if (i.price < j.price) return true;
	 		else if (i.price == j.price) {
	 			return (i.seq_no < j.seq_no);
	 		}
	 		return false;
	 		
	 	}
	 	else return false;
    }
};

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

		vector<rfp> proposals;
		desc original;
		original.total_requirements = n;
		for (int i = 0; i < n; i++) {
			//scanf("%s", str);
			gets(str);
		}
		
		for (int i = 0; i < p; i++) {
			//scanf("%s", str);
			gets(str);
			rfp prp;
			prp.name = str;
			scanf("%lf %d\n",&cost,&r);
			prp.total_met = r;
			prp.price = cost;
			prp.compliance = prp.total_met / (double) original.total_requirements;
			prp.seq_no = i;
			for (int j = 0; j < r; j++) {
				//scanf("%s", str);
				gets(str);
			}
			proposals.push_back(prp);
		}
		//printf("Before sort\n");
		//print_debug(proposals, p);

		sort(ALL(proposals), cmp_func);
		//sort(proposals.begin(), proposals.end(), Xgreater());
		//printf("After sort\n");
		//print_debug(proposals, p);

		printf("%s\n", proposals[0].name.c_str());
		proposals.clear();
	}
	return 0;
}
