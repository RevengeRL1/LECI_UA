#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <stdint.h>
#include <string.h>
#include <assert.h>

#include "linked-list.h"

/*******************************************************/

SllNode* sllDestroy(SllNode* list)
{
    return list;
}

/*******************************************************/

void sllPrint(SllNode *list, FILE *fout)
{
    SllNode *current = list;
    while(current != NULL)
    {
        fprintf(fout, "Student nmec: %u, Student name: %s\n", current->reg.nmec, current->reg.name);
        current = current->next;
    }
}

/*******************************************************/

SllNode* sllInsert(SllNode* list, uint32_t nmec, const char *name)
{
    assert(name != NULL && name[0] != '\0');
    assert(!sllExists(list, nmec));

    SllNode *newNode = (SllNode *)malloc(sizeof(SllNode));

    if(newNode == NULL){
        fprintf(stderr, "Memory allocation error\n");
        exit(1);
    }
    
    newNode->reg.nmec = nmec;
    newNode->reg.name = strdup(name);
    newNode->next = NULL;

    if (list == NULL || list->reg.nmec > nmec)
    {
        newNode->next = list;
        return newNode;
    }

    SllNode *current = list;
    while(current->next != NULL && current->next->reg.nmec < nmec)
    {
        current = current->next;
    }

    newNode->next = current->next;
    current->next = newNode;

    return list;

}

/*******************************************************/

bool sllExists(SllNode* list, uint32_t nmec)
{
    SllNode *current = list;
    
    while(current != NULL)
    {
        if (current->reg.nmec == nmec){ return true; }
        current = current->next;
    }
    return false;
}

/*******************************************************/

SllNode* sllRemove(SllNode* list, uint32_t nmec)
{
    assert(list != NULL);
    assert(sllExists(list, nmec));


    SllNode *current = list;
    SllNode *previous = NULL;

    while (current != NULL && current->reg.nmec != nmec)
    {
        previous = current;
        current = current->next;
    }

    if (current == NULL)
    {
        return list;
    }

    if (previous == NULL)
    {
        SllNode* newNode = list->next;
        free(list);
        return newNode;
    }

    previous->next = current->next;
    free(current);

    return list;
}

/*******************************************************/

const char *sllGetName(SllNode* list, uint32_t nmec)
{
    assert(list != NULL);
    assert(sllExists(list, nmec));

    SllNode *current = list;

    while(current != NULL)
    {
        if (current->reg.nmec == nmec)
        {
            return current->reg.name;
        }
        current = current->next;
    }

    return NULL;
}

/*******************************************************/

SllNode* sllLoad(SllNode *list, FILE *fin, bool *ok) // NOT WORKING
{
    assert(fin != NULL);

    uint32_t nmec;
    char name[80];

    SllNode *newNode, *current;

    if (ok != NULL)
       *ok = false; 

    while(fscanf(fin, " %79[^:]:%u", name, &nmec) == 2)
    {
        newNode = (SllNode*)malloc(sizeof(SllNode));
        if (newNode == NULL)
        {
            printf("Memory allocation failed\n");
            return list;
        }

        newNode->reg.nmec = nmec;
        strcpy(newNode->reg.name, name);
        newNode->next = NULL;

        if (list == NULL)
        {
            list = newNode;
        }
        else
        {
            current = list;
            while (current ->next != NULL)
            {
                current = current->next;
            }
            current->next = newNode;
        }
    }

    if (ok != NULL && list != NULL)
        *ok = true;

    return list;
}

/*******************************************************/

