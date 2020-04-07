import { FormGroup } from '@angular/forms';

export class FormHelper {

  static markFormAsTouched(formGroup: FormGroup): void {
    Object.keys(formGroup.controls).forEach(key => {
      formGroup.get(key).markAllAsTouched();
      if ((formGroup.controls[key] as FormGroup).controls) {
        this.markFormAsTouched(formGroup.controls[key] as FormGroup);
      }
    });
  }

}
