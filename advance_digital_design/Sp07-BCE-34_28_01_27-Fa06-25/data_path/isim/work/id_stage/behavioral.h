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

#ifndef H_Work_id_stage_behavioral_H
#define H_Work_id_stage_behavioral_H
#ifdef __MINGW32__
#include "xsimMinGW.h"
#else
#include "xsim.h"
#endif


class Work_id_stage_behavioral: public HSim__s6 {
public:

    HSim__s1 SE[8];

  char *t90;
  char *t91;
  char *t92;
HSimConstraints *c93;
HSimConstraints *c94;
HSimConstraints *c95;
    Work_id_stage_behavioral(const char * name);
    ~Work_id_stage_behavioral();
    void constructObject();
    void constructPorts();
    void reset();
    void architectureInstantiate(HSimConfigDecl* cfg);
    virtual void vhdlArchImplement();
};



HSim__s6 *createWork_id_stage_behavioral(const char *name);

#endif
