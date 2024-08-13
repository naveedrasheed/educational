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

#ifndef H_Work_alu_nvd_behavioral_H
#define H_Work_alu_nvd_behavioral_H
#ifdef __MINGW32__
#include "xsimMinGW.h"
#else
#include "xsim.h"
#endif


class Work_alu_nvd_behavioral: public HSim__s6 {
public:

    HSim__s4 PE[1];
    HSim__s1 SE[4];

    HSim__s1 SA[2];
HSimConstraints *c36;
  char *t37;
  char t38;
  char t39;
HSimConstraints *c40;
  char t41;
HSimConstraints *c42;
HSimConstraints *c43;
  char t44;
HSimConstraints *c45;
HSimConstraints *c46;
    Work_alu_nvd_behavioral(const char * name);
    ~Work_alu_nvd_behavioral();
    void constructObject();
    void constructPorts();
    void reset();
    void architectureInstantiate(HSimConfigDecl* cfg);
    virtual void vhdlArchImplement();
    void ConvFunc0(HSim__s2 * drv, const char * src, int noOfBytes, const HSimConstraints * srcConstraints);
};



HSim__s6 *createWork_alu_nvd_behavioral(const char *name);

#endif
