package route;

import java.io.*;
import java.util.*;

/**
 * CLASSE DE EXCEP��O: EstNaoExiste
 * 
 */
public class EstNaoExiste extends Exception
{
	

	/**
	 * Construtores de EstNaoExiste
	 */
	public EstNaoExiste()
	{
		super();
	}

    public EstNaoExiste(String s)
	{
		super(s);
	}
	
}