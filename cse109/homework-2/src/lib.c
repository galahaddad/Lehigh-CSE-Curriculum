#include <stdbool.h>
#include <dirent.h>
#include <string.h> // for strcmp
#include <stdio.h>
#include "../include/whichtools.h"
#include <unistd.h> //https://pubs.opengroup.org/onlinepubs/007904975/functions/access.html

bool file_exists(char* path) {
    /*
    File exists done using a function I found looking through C documentation. 
    Does what whas intended from the my_ls lab in a faster manner.
    */
    if(access(path, F_OK) != -1) {
        return true;
    } else {
        return false;
    }
}