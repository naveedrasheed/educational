////////////////////////////////////////////////////////////////////////////////
//   ____  ____   
//  /   /\/   /  
// /___/  \  /   
// \   \   \/  
//  \   \        Copyright (c) 2003-2004 Xilinx, Inc.
//  /   /        All Right Reserved. 
// /---/   /\     
// \   \  /  \  
//  \___\/\___\
////////////////////////////////////////////////////////////////////////////////

#ifndef H_Work_if_stage_behavioral_H
#define H_Work_if_stage_behavioral_H
#ifdef __MINGW32__
#include "xsimMinGW.h"
#else
#include "xsim.h"
#endif


class Work_if_stage_behavioral: public HSim__s6 {
public:

    HSim__s1 SE[10];

    HSim__s1 SA[1];
HSimConstraints *c84;
  char *t85;
    Work_if_stage_behavioral(const char * name);
    ~Work_if_stage_behavioral();
    void constructObject();
    void constructPorts();
    void reset();
    void architectureInstantiate(HSimConfigDecl* cfg);
    virtual void vhdlArchImplement();
};



HSim__s6 *createWork_if_stage_behavioral(const char *name);

#endif
