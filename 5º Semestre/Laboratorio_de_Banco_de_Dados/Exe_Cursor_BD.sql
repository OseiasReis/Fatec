DECLARE
    CURSOR cPROF 
    IS
    SELECT NOMEPROF FROM PROFESSOR WHERE PROFESSOR.CODTIT != 3;
    
    vNOME PROFESSOR.vNOMEPROF%TYPE;
    
BEGIN
    OPEN cPROF;
    LOOP
        FETCH cPROF INTO vNOME;
        EXIT WHEN cPROF%NOTFOUND;
        SYS.DBMS_OUTPUT.PUT_LINE(vNOME);
    END LOOP;
    CLOSE cPROF;
END;