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

#ifndef H_Work_r_f_behavioral_H
#define H_Work_r_f_behavioral_H
#ifdef __MINGW32__
#include "xsimMinGW.h"
#else
#include "xsim.h"
#endif


class Work_r_f_behavioral: public HSim__s6 {
public:

    HSim__s4 PE[1];
    HSim__s1 SE[9];

  HSimArrayType Regibase;
  HSimArrayType Regi;
    HSim__s1 SA[1];
    Work_r_f_behavioral(const char * name);
    ~Work_r_f_behavioral();
    void constructObject();
    void constructPorts();
    void reset();
    void architectureInstantiate(HSimConfigDecl* cfg);
    virtual void vhdlArchImplement();
};



HSim__s6 *createWork_r_f_behavioral(const char *name);

#endif
