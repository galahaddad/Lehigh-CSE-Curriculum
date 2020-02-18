#include <stdbool.h>
#include <dirent.h>
#include <string.h> // for strcmp
#include <stdio.h>

bool file_exists(char* path, char* keyword) {


    //USE ACESSSSSSS COMMANDDDDDDDDDDDDD
    bool result = false;
    DIR* dir = opendir("path");
    struct dirent* entry;
    while((entry = readdir(dir)) != NULL) {
        char* name = entry->d_name;
        if(strcmp(name, keyword) == 0){
            result = true;
        } else {
            result = false;
        }
    }
    return result;

}