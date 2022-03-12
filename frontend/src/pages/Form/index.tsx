import { FormCard } from 'components/FormCard'
import { useParams } from 'react-router-dom'

export const Form = () => {
  const params = useParams()

  return <FormCard movieId={`${params.movieId}`} />
}
