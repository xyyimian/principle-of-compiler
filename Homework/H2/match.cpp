#include <iostream>
#include <string>
using namespace std;

int main(){
	int state = 0;
	string s;
	cout << "input source string:" <<endl;
	cin >> s;
	
	auto cb = s.cbegin();
	auto subcb = cb;	//record start address of substring
	char c;
	bool state0out[2] = {false,false};	//mark array 
	
	
	while( cb != s.cend() ){
		c = *cb;
		switch(state){
			case 0:
				if(!state0out[0]){
					state = 1;
					state0out[0] = true;	//randomly select a path 
					continue;
				}
				else if(!state0out[1]){
					state = 3;
					state0out[1] = true;
					continue;
				}
				else{	//end seraching all paths
					cout << "Unknown Character:" << c << endl;
					state0out[0] = false;
					state0out[1] = false;	//recover mark array
				}
				break;
			case 1:
				if(c == 'a'){
					state = 2;
					subcb = cb;
				}
				else{
					state = 0;
					--cb;
				}
				break;
			case 2:
				if(c != 'a'){
					string substring(subcb,cb);
					cout << substring << "\t\t" << subcb-s.cbegin() <<endl;
					state0out[0] = false;
					state0out[1] = false;
					state = 0;					
					--cb;	//retract 
				}
				break;
			case 3:
				if(c == 'b'){
					state = 4;
					subcb = cb;
				}
				else{
					state = 0;
					--cb;
				}
				break;
			case 4:
				if(c != 'b'){
					string substring(subcb,cb);
					cout << substring << "\t\t" << subcb-s.cbegin() <<endl;
					state0out[0] = false;
					state0out[1] = false;
					state = 0;
					--cb;	//retract
				}
				break;
			default:
				;
		}
		++cb;
	}
	if(cb != subcb){
		string substring(subcb,cb);
		cout << substring << "\t\t" << subcb-s.cbegin() <<endl;
	}
} 
