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

#ifndef H_Work_ex_stage_behavioral_H
#define H_Work_ex_stage_behavioral_H
#ifdef __MINGW32__
#include "xsimMinGW.h"
#else
#include "xsim.h"
#endif


class Work_ex_stage_behavioral: public HSim__s6 {
public:

    HSim__s1 SE[7];

    HSim__s1 SA[1];
  char t106;
HSimConstraints *c107;
    Work_ex_stage_behavioral(const char * name);
    ~Work_ex_stage_behavioral();
    void constructObject();
    void constructPorts();
    void reset();
    void architectureInstantiate(HSimConfigDecl* cfg);
    virtual void vhdlArchImplement();
};



HSim__s6 *createWork_ex_stage_behavioral(const char *name);

#endif
