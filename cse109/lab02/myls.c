#include<stdio.h>
#include<string.h>
#include<dirent.h>
#include<stdbool.h>
int main(int argc, char** argv) {
    bool flag_a = false;
    bool flag_l = false;
    for (int i = 0; i < argc; i++)
    {
        if(strcmp(argv[i], "-a") == 0) {
            flag_a=true;
        }
        else if(strcmp(argv[i], "-l") == 0) {
            flag_l=true;
        }
    }
    struct dirent* directory_entry;
    DIR* dir=opendir(".");  //open current directory_entry
        
    //use the flags
    while(directory_entry = readdir(dir) != NULL) {    
        char* name = directory_entry->d_name;
        int type = directory_entry->d_type;
        printf("Name: %s Type: %d\n", name, type);
    }

    if(flag_a){
        printf("A");
    }
    if(flag_l){
        printf("L");
    }
    printf("\n");
    return 0;
}
