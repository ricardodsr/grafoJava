package route;

import java.io.*;
import java.util.*;

/**
 * CLASSE DE EXCEPÇÃO: LigNaoExiste
 * 
 */
public class LigNaoExiste extends Exception
{
	

	/**
	 * Construtores de LigNaoExiste
	 */
	public LigNaoExiste()
	{
		super();
	}

    public LigNaoExiste(String s)
	{
		super(s);
	}
	
}