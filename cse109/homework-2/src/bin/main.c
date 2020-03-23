#include "../../include/whichtools.h"
#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>
#include <string.h>
/* Ralph Haddad, my-which homework-2, Corey Montella
*/
int main(int argc, char **argv) {
    bool a_flag = false;    //a_flag condition
    int condition = 0;
    int a = 0;
    int loopCondition = 1;
    char *currentPath;      //the current path
    char *seekingPath;      //the path snipped from strtok
    char *ptr = getenv("PATH");
    char path[10000];

    //in the case where there is no argument, exits the executeable.
    if (argc == 1) {
        return 2;
    }
    //parse for the -a flag in the executeable run anywhere
    //flag and input are position independent
    for(int i = 1; i < argc; i++) {
        if (strcmp(argv[i], "-a") == 0) {
            a_flag = true;
            a = i;
        }
    }
    
    for (int i = 1; i < argc; i++) {
        if(a != i) {
            //takes the charstrings to use as paths below
            strcpy(path, ptr);
            currentPath = strtok(path, ":");    //parse by colons
            seekingPath = malloc(strlen(currentPath) + 1);  //reallocates memory of currentPath up one

            while (currentPath != NULL) {
                strcpy(seekingPath, currentPath); //selects path
                strcat(seekingPath, "/");   //appends seekingPath
                strcat(seekingPath, argv[i]);   
                if(file_exists(seekingPath) == true) {
                    loopCondition = 0;
                    printf("%s\n", seekingPath);
                    if(!a_flag) {   //prints explicitly one path if the a_flag is not true
                        break;
                    }
                }
                currentPath = strtok(NULL, ":");    //prepares for the next parsed PATH
            }
            if (loopCondition == 1) {
                condition = 1;
            }
        }
    }
    return condition;
}
