package annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import core.TesteBase;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface PreRequisito {

	//apenas um pre-requisito
	Class<? extends TesteBase> value();

}
