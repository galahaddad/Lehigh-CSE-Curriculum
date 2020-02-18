#include <stdio.h>
#include <stdbool.h>
#include <string.h>     //See the library for string.h. 
#include <dirent.h>
#include <stdlib.h>     /* getenv */
#include "whichtools.h" //includes the library of functions for which



int main(int argc, char** argv) {
	//set up flag variable
    bool flag_a = false;
    //see if flags are used
    char* keyword = argv[1];
    int j = 0;
    // for(int ix=0; ix<argc; ix++) {
    //     if (strcmp(argv[ix],"-a")==0)
    //     {
    //         flag_a = true;
    //     }
    //     if (strcmp(argv[ix],"-a")==1) {
    //         keywords[j] = argv[ix];
    //         j++;
    //     }
    // }
    //Parses out the path directory into seperated directory paths
    char* pPath;
    char* pch;
    int i=0;
    pPath = getenv("PATH");
    pch = strtok(pPath, ":");
    while(pch != NULL)
    {
        
        //if (file_exists(pch, keyword)) {
            //prints the current directory
            printf("%s \n", pch);
        //}

        // //setup for directory print
        // DIR* dir = opendir("pch");  //creates a directory for the current path being followed
        // struct dirent* entry;   //sets a structure for the currently entered path
        // //internally checks everything within each directory in path for the file
        // while((entry = readdir(dir)) != NULL) {
        //         printf("%s \n", pch);
            
        // }
        // closedir(dir);
        pch = strtok (NULL, ":");
    }
    return 0;

    

}

