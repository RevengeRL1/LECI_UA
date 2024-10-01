#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <errno.h>
#include <stdint.h>
#include <string.h>
#include <assert.h>

#include "linked-list.h"

/*******************************************************/

/**
 * \brief The data to be stored in the list
 */
struct Student
{
    uint32_t nmec;        ///< Student number
    char *name;     ///< Student name
};

/**
 * \brief The linked-list support data structure:
 */
struct SllNode 
{
    Student reg;          ///< Student data
    struct SllNode *next;    ///< Pointer to next node
};

/*******************************************************/

static SllNode *list = NULL;

/*******************************************************/

void sllDestroy()
{
}

/*******************************************************/

void sllPrint(FILE *fout)
{
    SllNode *current = list;
    while(current != NULL)
    {
        fprintf(fout, "NMEC: %u, Name: %s\n", current->reg.nmec, current->reg.name);
        current = current->next;
    }
}

/*******************************************************/

void sllInsert(uint32_t nmec, const char *name)
{
    assert(name != NULL && name[0] != '\0');
    assert(!sllExists(nmec));

    SllNode *newNode = (SllNode *)malloc(sizeof(SllNode));
    SllNode *current = list;

    if (newNode == NULL)
    {
        fprintf(stderr, "Memory allocation error!\n");
        exit(1);
    }

    newNode->reg.nmec = nmec;
    newNode->reg.name = strdup(name);
    newNode->next = NULL;

    if (list == NULL || list->reg.nmec > nmec)
    {
        newNode->next = list;
        list = newNode;
    }

    else
    {
        while(current->next->reg.nmec < nmec)
        {
            current = current->next;
        }
        newNode->next = current->next;
        current->next = newNode;
    }
     
}

/*******************************************************/

bool sllExists(uint32_t nmec)
{
    if (list == NULL)
    {
        return false;
    }
    
    SllNode *current = list;

    while (current != NULL)
    {
        if (current->reg.nmec == nmec)
        {
            return true;
        }
        current = current->next;
    }
    return false;
}

/*******************************************************/

void sllRemove(uint32_t nmec)
{
    assert(sllExists(nmec));
}

/*******************************************************/

const char *sllGetName(uint32_t nmec)
{
    assert(sllExists(nmec));

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

bool sllLoad(FILE *fin)
{
    assert(fin != NULL);

    return false;
}

/*******************************************************/

